package net.wowdev.ecommerce.domain.generator;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.EnumSet;
import org.hibernate.Session;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.generator.AnnotationBasedGenerator;
import org.hibernate.generator.BeforeExecutionGenerator;
import org.hibernate.generator.EventType;
import org.hibernate.generator.GeneratorCreationContext;
import org.springframework.stereotype.Component;

/**
 * Database-agnostic order-number generator backed by a database sequence. Hibernate adapts the
 * sequence access to the configured dialect.
 */
@Component
public final class OrderNumberGenerator
    implements BeforeExecutionGenerator, AnnotationBasedGenerator<GeneratedOrderNumber> {

  @PersistenceContext private EntityManager entityManager;

  private String sequenceName = "order_number_seq";

  static String format(long sequence, int year) {
    return "ORD-%04d-%08d".formatted(year, sequence);
  }

  @Override
  public void initialize(GeneratedOrderNumber annotation, GeneratorCreationContext context) {
    sequenceName = annotation.sequenceName();
  }

  @Override
  public Object generate(
      SharedSessionContractImplementor session,
      Object owner,
      Object currentValue,
      EventType eventType) {
    Number nextValue = getNextValue(sequenceName);
    return format(nextValue.longValue(), java.time.Year.now().getValue());
  }

  public Long getNextValue(String sequenceName) {
    Session session = entityManager.unwrap(Session.class);
    SessionFactoryImplementor sessionFactory =
        (SessionFactoryImplementor) session.getSessionFactory();
    Dialect dialect = sessionFactory.getJdbcServices().getDialect();

    // Hibernate automatically creates the correct "SELECT nextval..." or "...NEXTVAL FROM DUAL"
    String sql = dialect.getSequenceSupport().getSequenceNextValString(sequenceName);

    Object result = session.createNativeQuery(sql, Object.class).getSingleResult();
    return Long.parseLong(result.toString());
  }

  @Override
  public EnumSet<EventType> getEventTypes() {
    return EnumSet.of(EventType.INSERT);
  }

  @Override
  public boolean generatedOnExecution() {
    return false;
  }
}
