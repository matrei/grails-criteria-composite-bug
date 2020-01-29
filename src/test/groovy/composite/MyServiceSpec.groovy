package composite

import grails.test.hibernate.HibernateSpec
import grails.testing.gorm.DataTest
import grails.testing.services.ServiceUnitTest
import spock.lang.Unroll

class MyServiceSpec extends HibernateSpec implements ServiceUnitTest<MyService>, DataTest {

    List<Class> getDomainClasses() { [Domain1, Domain2, Domain1Domain2] }

    @Unroll
    void "test criteria #titleWord accessing composite property"() {
        when: 'Domain objects are stored in the db'
        Domain1.withTransaction {
            Domain1 domain1 = new Domain1(name: 'abc').save()
            Domain2 domain2 = new Domain2(name: 'cde').save()
            new Domain1Domain2(domain1: domain1, domain2: domain2, myValue: 1).save()
        }

        and: 'service is invoked with search term'
        def result = service.list(searchText)

        then: 'the result is correct'
        result.size() == resultSize

        where:
        titleWord | searchText | resultSize
        'without' | null       | 1
        'with'    | 'b'        | 0
    }
}
