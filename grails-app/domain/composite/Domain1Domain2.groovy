package composite

class Domain1Domain2 implements Serializable {

    Domain1 domain1
    Domain2 domain2
    int myValue

    static mapping = {
        id composite: ['domain1', 'domain2']
        version false
    }
}
