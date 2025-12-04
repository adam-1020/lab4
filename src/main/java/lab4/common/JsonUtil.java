package lab4.common;

public class JsonUtil {
    // Zamiana obiektu Move na "JSON"
    public static String toJson(Move m) {
        return "{\"x\":" + m.x + ",\"y\":" + m.y + ",\"player\":" + m.player + "}";
    }

    // Parsowanie JSON -> Move
    public static Move fromJson(String json) {
        json = json.trim();
        json = json.substring(1, json.length() - 1); // usuń { }

        String[] parts = json.split(",");
        int x = 0, y = 0, player = 0;

        for (String part : parts) {
            String[] pair = part.split(":");
            String key = pair[0].trim().replace("\"", "");
            int value = Integer.parseInt(pair[1].trim());

            switch (key) {
                case "x": x = value; break;
                case "y": y = value; break;
                case "player": player = value; break;
            }
        }

        return new Move(x, y, player);
    }
}