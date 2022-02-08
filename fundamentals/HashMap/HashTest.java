import java.util.HashMap;
import java.util.Set;

public class HashTest {
    public static void main(String[] args) {
        HashMap trackList = new HashMap();
        trackList.put("song a", "lyrics a");
        trackList.put("song b", "lyrics b");
        trackList.put("song c", "lyrics c");
        trackList.put("song d", "lyrics d");
        System.out.println(trackList.get("song a"));
        Set<String> keys = trackList.keySet();
        for (String key : keys)
            System.out.println(key + ": " + trackList.get(key));
    }
}
