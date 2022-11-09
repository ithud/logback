package ch.qos.logback.classic.foreverland.logger;

import java.util.Map;

/**
 * @author Thud
 * @date 2022/11/9
 */
public class DefaultBuilder extends AbstractBuilder {

    @Override
    public String builderMsg(String msg) {
        Map<String,String> fields = super.getFields();
        fields.putAll(LoggerEvent.getContext());
        StringBuilder stringBuilder = new StringBuilder("{ ");
        for (Map.Entry<String,String> params : fields.entrySet()){
            stringBuilder.append(params.getKey()).append("=").append(params.getValue());
        }
        stringBuilder.append(" }").append("msg:").append(msg);
        return stringBuilder.toString();
    }
}
