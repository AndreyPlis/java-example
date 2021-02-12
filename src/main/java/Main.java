import component.ImageComponent;
import component.LabelComponent;
import dashboard.*;

import java.util.Collections;

public class Main {

    public static void main(String... args){

        Dashboard dash = new RunnableDashboard();
        AbstractDashboard dash2 = new EditableDashboard();

//имплементация методов

        dash.start();
        dash2.start();

        dash.redirect("RunnableDashboard_URL");
        dash2.redirect("EditableDashboard_URL");

        dash.search("RunnableDashboard_search");
        dash2.search("EditableDashboard_search");

        LabelComponent label1 = new LabelComponent(0, 0, 100);
        LabelComponent label2 = new LabelComponent(1, 1, 50);
        LabelComponent label3 = new LabelComponent(2, 2, 20);

        ImageComponent image1 = new ImageComponent(3, 3, 200);
        ImageComponent image2 = new ImageComponent(4, 4, 55);
        ImageComponent image3 = new ImageComponent(5, 5, 77);

        dash.addComponent(label1);
        dash.addComponent(label2);
        dash.addComponent(label3);

        dash2.addComponent(image1);
        dash2.addComponent(image2);
        dash2.addComponent(image3);

//Проверки методов

        System.out.printf("dash has %d elements \n", dash.componentsSize());
        System.out.printf("dash2 has %d elements \n", dash2.componentsSize());

        dash.removeComponent(label2);
        dash2.removeComponent(image2);

//Клонирование

        Dashboard cloneDash = dash.clone();
        Dashboard cloneDash2 = dash2.clone();
        Dashboard cloneDash3 = dash.clone();

        cloneDash.addComponent(label2);
        cloneDash2.addComponent(image2);

        System.out.printf("dash has %d elements \n", dash.componentsSize());
        System.out.printf("dash2 has %d elements \n", dash2.componentsSize());

        System.out.printf("cloneDash has %d elements \n", cloneDash.componentsSize());
        System.out.printf("cloneDash2 has %d elements \n", cloneDash2.componentsSize());

//Сортировка

        cloneDash.sortComponents();
        cloneDash2.sortComponents();

        System.out.printf("cloneDash after sortComponents() first element has size %d \n", cloneDash.getElementSize(0));
        System.out.printf("cloneDash2 after sortComponents() first element has size %d \n", cloneDash2.getElementSize(0));

//Сравнение

        System.out.printf("dash equals dash %s \n", dash.equals(dash) ? "YES" : "NO");
        System.out.printf("dash equals dash2 %s \n", dash.equals(dash2) ? "YES" : "NO");
        System.out.printf("dash equals cloneDash %s \n", dash.equals(cloneDash) ? "YES" : "NO");
        System.out.printf("dash equals cloneDash3 %s \n", dash.equals(cloneDash3) ? "YES" : "NO");

        System.out.printf("dash hashCode %d \n", dash.hashCode());
        System.out.printf("cloneDash hashCode %d \n", cloneDash.hashCode());
        System.out.printf("cloneDash3 hashCode %d \n", cloneDash3.hashCode());

//Билдер

        RunnableDashboard newRunnableDashboard = new RunnableDashboard.Builder()
                .addElement(label3)
                .addElement(label2)
                .addElement(label1)
                .build();

        EditableDashboard newEditableDashboard = new EditableDashboard.Builder()
                .addElement(image3)
                .addElement(image2)
                .addElement(image1)
                .build();

        System.out.printf("newRunnableDashboard has %d elements \n", newRunnableDashboard.componentsSize());
        System.out.printf("newEditableDashboard has %d elements \n", newEditableDashboard.componentsSize());

        System.out.printf("newRunnableDashboard first element has size %d \n", newRunnableDashboard.getElementSize(0));
        System.out.printf("newEditableDashboard first element has size %d \n", newEditableDashboard.getElementSize(0));

        System.out.printf("dash equals newRunnableDashboard %s \n", dash.equals(newRunnableDashboard) ? "YES" : "NO");
        System.out.printf("dash2 equals newEditableDashboard %s \n", dash2.equals(newEditableDashboard) ? "YES" : "NO");

        dash.stop();
        dash2.stop();
    }
}