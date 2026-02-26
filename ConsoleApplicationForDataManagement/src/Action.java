/*
Представляет собой вариант, выбранный пользователем
 */

import java.util.Objects;
import java.util.stream.Stream;

public enum Action {
    EXIT(0, false), //любой ввод состоит из правил или команд
    CREATE(1, true),
    UPDATE(2, true),
    DELETE(3, true),
    STATS_BY_COURSE(4, false),
    SEARCH(5, true),
    ERROR(-1, false);


    public Integer getCode() {
        return code;
    }

    public boolean isReqiredAditionalData() {
        return reqiredAditionalData;
    }

    private Integer code; //(это раскидка для цифорок из printMessage)
    private boolean reqiredAditionalData; //нужно для понимания, для выбранного пункта нужны ли дополнительные данные

    Action(Integer code, boolean reqiredAditionalData) {
        this.code = code;
        this.reqiredAditionalData = reqiredAditionalData;
    }

    public static Action fromCode(Integer code) {
        return Stream.of(Action.values())
                .filter(action -> Objects.equals(action.getCode(), code))
                .findFirst()
                .orElseGet(() -> {
                    System.out.println("Неизвестный код действия: " + code);
                    return Action.ERROR;
                });
    }
}
