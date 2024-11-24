import java.util.ArrayList;
import java.util.List;

// Интерфейс наблюдателя
interface ChangeListener {
    void onChange(String newState);
}

// Класс ObservableStringBuilder
public class ObservableStringBuilder {
    private final StringBuilder stringBuilder;
    private final List<ChangeListener> listeners;

    // Конструктор
    public ObservableStringBuilder() {
        this.stringBuilder = new StringBuilder();
        this.listeners = new ArrayList<>();
    }

    public ObservableStringBuilder(String initial) {
        this.stringBuilder = new StringBuilder(initial);
        this.listeners = new ArrayList<>();
        notifyListeners();
    }

    // Добавление наблюдателя
    public void addChangeListener(ChangeListener listener) {
        listeners.add(listener);
    }

    // Удаление наблюдателя
    public void removeChangeListener(ChangeListener listener) {
        listeners.remove(listener);
    }

    // Уведомление всех наблюдателей
    private void notifyListeners() {
        String currentState = stringBuilder.toString();
        for (ChangeListener listener : listeners) {
            listener.onChange(currentState);
        }
    }

    // Методы StringBuilder с уведомлением
    public ObservableStringBuilder append(String str) {
        stringBuilder.append(str);
        notifyListeners();
        return this;
    }

    public ObservableStringBuilder insert(int offset, String str) {
        stringBuilder.insert(offset, str);
        notifyListeners();
        return this;
    }

    public ObservableStringBuilder replace(int start, int end, String str) {
        stringBuilder.replace(start, end, str);
        notifyListeners();
        return this;
    }

    public ObservableStringBuilder delete(int start, int end) {
        stringBuilder.delete(start, end);
        notifyListeners();
        return this;
    }

    public ObservableStringBuilder reverse() {
        stringBuilder.reverse();
        notifyListeners();
        return this;
    }

    public int length() {
        return stringBuilder.length();
    }

    public String toString() {
        return stringBuilder.toString();
    }
}
