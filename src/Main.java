public class Main {
    public static void main(String[] args) {

        StringBuilderUs StringBuilderUs = new StringBuilderUs(" Eto nachalo");

        StringBuilderUs.addWatcher(newState -> {
            System.out.println("Состояние изменено: " + newState);
        });
        StringBuilderUs.append(", no skoro konec");
        StringBuilderUs.insert(0, " Escho ne skoro ");
        StringBuilderUs.replace(0, 4, " aaa ");
        StringBuilderUs.reverse();
        StringBuilderUs.delete(0, 3);
    }
}