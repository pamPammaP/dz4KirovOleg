public class Main {
    public static void main(String[] args) {
        // Создаём ObservableStringBuilder
        ObservableStringBuilder observableStringBuilder = new ObservableStringBuilder("Hello");

        // Добавляем наблюдателя
        observableStringBuilder.addChangeListener(newState -> {
            System.out.println("Состояние изменено: " + newState);
        });

        // Пример работы
        observableStringBuilder.append(", world!");
        observableStringBuilder.insert(0, "Say: ");
        observableStringBuilder.replace(0, 4, "Shout");
        observableStringBuilder.reverse();
        observableStringBuilder.delete(0, 3);
    }
}