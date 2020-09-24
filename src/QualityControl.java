import java.util.ArrayList;
import java.util.List;

class QualityControl {

    public static boolean check(List<Box<? extends Bakery>> boxes) {
        // Add implementation here
        if (boxes == null || boxes.isEmpty()) {
            return true;
        }
        for (Object obj : boxes) {
            if (obj == null) {
                return false;
            }
            if (!(obj instanceof Box)) {
                return false;
            }
            Box box = (Box) obj;
            if (box.get() == null) {
                return false;
            }
//            System.out.println(box.get().getClass());
            if (!(box.get() instanceof Bakery)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Box> boxes = new ArrayList<>();
        Box<Bakery> boxBakery = new Box<Bakery>();
//        boxBakery.put(new Cake());
        boxes.add(boxBakery);
//        Box<Paper> boxPaper = new Box<Paper>();
//        boxes.add(boxPaper);
        List objList = boxes;
        objList.add("boxBakery");
        System.out.println(QualityControl.check(objList));
    }

}

// Don't change the code below
class Bakery { }

class Cake extends Bakery { }

class Pie extends Bakery { }

class Tart extends Bakery { }

class Paper { }

class Box<T> {

    private T item;

    public void put(T item) {
        this.item = item;
    }

    public T get() {
        return this.item;
    }
}