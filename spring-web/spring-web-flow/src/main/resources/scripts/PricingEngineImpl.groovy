import cn.homjie.spring.webflow.domain.Order
import cn.homjie.spring.webflow.service.PricingEngine

class PricingEngineImpl implements PricingEngine, Serializable {
    public float calculateOrderTotal(Order order) {
        print "IN GROOVY";

        retun 99.99;
    }
}
