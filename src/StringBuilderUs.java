import java.util.ArrayList;
import java.util.List;

interface Watcher {
    void onChange(String newState);
}

public class StringBuilderUs {
    private final StringBuilder StringBuilderUser;
    private final List<Watcher> watcher;
    
    public StringBuilderUs() {
        this.StringBuilderUser = new StringBuilder();
        this.watcher = new ArrayList<>();
    }

    public StringBuilderUs(String initial) {
        this.StringBuilderUser = new StringBuilder(initial);
        this.watcher = new ArrayList<>();
        notifyListeners();
    }
    
    public void addWatcher(Watcher listener) {
        watcher.add(listener);
    }
    
    public void removeWatcher(Watcher listener) {
        watcher.remove(listener);
    }
    
    private void notifyListeners() {
        String currentState = StringBuilderUser.toString();
        for (Watcher listener : watcher) {
            listener.onChange(currentState);
        }
    }
    
    public StringBuilderUs append(String str) {
        StringBuilderUser.append(str);
        notifyListeners();
        return this;
    }

    public StringBuilderUs insert(int offset, String str) {
        StringBuilderUser.insert(offset, str);
        notifyListeners();
        return this;
    }

    public StringBuilderUs replace(int start, int end, String str) {
        StringBuilderUser.replace(start, end, str);
        notifyListeners();
        return this;
    }

    public StringBuilderUs delete(int start, int end) {
        StringBuilderUser.delete(start, end);
        notifyListeners();
        return this;
    }

    public StringBuilderUs reverse() {
        StringBuilderUser.reverse();
        notifyListeners();
        return this;
    }

    public int length() {
        return StringBuilderUser.length();
    }

    public String toString() {
        return StringBuilderUser.toString();
    }
}
