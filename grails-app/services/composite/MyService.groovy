package composite

import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

@Transactional
class MyService {

    @ReadOnly
    def list(String searchText) {
        Domain1Domain2.createCriteria().list() {
            if(searchText) {
                or {
                    domain1 { ilike 'name', "%${searchText}%"}
                    domain2 { ilike 'name', "%${searchText}%"}
                }
            }
        }
    }
}
