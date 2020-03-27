package Lesson_5;

public class HomeWork_6 {
    public static void main(String[] args) {

        Storage myStorage = new Storage();
        Storage emptyStorage = new Storage();

        myStorage.addMaterial(new Circle(),2);
        myStorage.addMaterial(new Triangle(), 3);
        myStorage.addMaterial(new Square(),1);

        House houseOne = new House();
        houseOne.attachStorage(myStorage);
        try {
            if (houseOne.getStorage().checkMatrials()) {
                houseOne.build();
            } else
                System.out.println("Для постройки не хватает материалов");
            //по хорошему нужно еще добавить метод выводящий какого метариала не хватает
        }
        catch (NullPointerException e) {
            System.out.println("К дому не привазано хранилища");
        }

        House houseTwo = new House();
        houseTwo.attachStorage(emptyStorage);
        try {
            if (houseTwo.getStorage().checkMatrials()) {
                houseTwo.build();
            } else
                System.out.println("Для постройки не хватает материалов");
            //по хорошему нужно еще добавить метод выводящий какого метариала не хватает
        }
        catch (NullPointerException e) {
            System.out.println("К дому не привазано хранилища");
        }
    }

}


class House implements BuildMaterial {

    private Storage storage;  //склад с которого буду браться мателиалы

    //метод связывающий хранилище и дом
    public void attachStorage (Storage storage) {
        this.storage = storage;
    }

    //методы возвращающий ссылку на хранилище закрепленное за домом
    public Storage getStorage() {
        return storage;
    }

    @Override
    public void build() {
        storage.removeMaterial(storage.square,1);
        System.out.println("Строим квадрат");
        storage.removeMaterial(storage.triangle,1);
        System.out.println("Строим треуголиньк");
        storage.removeMaterial(storage.circle,1);
        System.out.println("Строим круг");

    }

}
