package library.reactivecontrollers;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="books.settings")
public class BookControllerConfigurationReactive {
    private int pageSize=1;
    private boolean orderByIdDesc = false;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isOrderByIdDesc() {
        return orderByIdDesc;
    }

    public void setOrderByIdDesc(boolean orderByIdDesc) {
        this.orderByIdDesc = orderByIdDesc;
    }
}
