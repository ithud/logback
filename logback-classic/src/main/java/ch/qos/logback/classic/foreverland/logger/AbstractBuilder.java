package ch.qos.logback.classic.foreverland.logger;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Thud
 * @date 2022/11/9
 */
public abstract class AbstractBuilder implements IBuilder {

    private final Map<String,String> detectedField = new HashMap<>();

    @Override
    public IBuilder of(String k, String v) {
        detectedField.put(k,v);
        return this;
    }
    public Map<String,String> getFields(){
        return detectedField;
    }
}
