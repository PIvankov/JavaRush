package level_28.waitNotify.t2;

public class Person implements Runnable {
    private final Mail mail;

    public Person(Mail mail) {
        this.mail = mail;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (mail) {
            try {
                Thread.sleep(1000);
                //сделайте что-то тут - do something here
                mail.setText("Person [" + name + "] wrote an email 'AAA'");
                //сделайте что-то тут - do something here
                mail.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

