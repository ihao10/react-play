package message;

import java.io.Serializable;

/** server与client交互的协议，只是做个标记，TODO 有没有更好的方法，像protobuf那样 */
public interface AppMessage extends Serializable {
}
