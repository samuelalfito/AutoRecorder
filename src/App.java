import java.util.Scanner;

import system.Click;
import system.IRunnable;
import system.SinglyLinkedList;
import system.WaitTime;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        SinglyLinkedList<IRunnable> linkedList = new SinglyLinkedList<>();

        System.out.println("=+======---- Auto Click  by Meouz ----======+=");
        System.out.println(guideBook());

        while (true) {
            try {
                int select = scan.nextInt();
                switch (select) {
                    case 1:
                        System.out.println(guideBook());
                        break;
                    case 2:
                        System.out.print("Mouse x: ");
                        int x = scan.nextInt();
                        System.out.print("Mouse y: ");
                        int y = scan.nextInt();
                        Click click = new Click(x, y);
                        linkedList.addItem(click);
                        break;
                    case 3:
                        System.out.print("Wait Time: ");
                        int timer = scan.nextInt();
                        WaitTime waitTime = new WaitTime(timer);
                        linkedList.addItem(waitTime);
                        break;
                    case 4:
                        System.out.println("How many times do you want to run?");
                        linkedList.run(scan.nextInt());
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        scan.close();
                        return;
                    default:
                        System.out.println("Something went wrong. Try again");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Input missmatch. Try Again");
            }
        }
    }

    public static String guideBook() {
        return "==========----- MINI GUIDEBOOK -----==========\n" +
                "1. Show Mini GuideBook\n" +
                "2. Add Click\n" +
                "3. Add Timer" +
                "4. Run Code\n" +
                "5. Exit\n";
    }
}
