package designPattern.observe;


import java.util.Observable;
import java.util.Observer;

/**
 * Created by mingchuw on 16/6/27.
 * observer & observable pattern
 */

public class MyObServerServer extends Observable {
    public MyObServerServer() {

    }

    public void work() {
        ObServerMessage message = new ObServerMessage("1", "value1");
        super.setChanged();
        super.notifyObservers(message);
        message.setType("2");
        super.setChanged();
        super.notifyObservers(message);
    }

    static class ObServerMessage {
        //    private
        private String type;
        private String value;

        public ObServerMessage(String type, String value) {
            this.type = type;
            this.value = value;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }





    static class MyObserver1 implements Observer {

        public MyObserver1(MyObServerServer server) {
            server.addObserver(this);
        }

        @Override
        public void update(Observable o, Object arg) {
            ObServerMessage info = (ObServerMessage) arg;
            if (info.getType().equals("1")) {
                System.out.println("MyObserver1 get message " + info.getValue());
            }
        }
    }

    static class MyObserver2 implements Observer {

        public MyObserver2(MyObServerServer server) {
            server.addObserver(this);
        }

        @Override
        public void update(Observable o, Object arg) {
            ObServerMessage info = (ObServerMessage) arg;
            if (info.getType().equals("2")) {
                System.out.println("MyObserver2 get message " + info.getValue());
            }
        }
    }

    public static void main(String[] args) {
        MyObServerServer myObServerServer = new MyObServerServer();
        MyObserver1 myObserver1  = new MyObserver1(myObServerServer);
        MyObserver1 myObserver2  = new MyObserver1(myObServerServer);
        myObServerServer.work();
    }
}
