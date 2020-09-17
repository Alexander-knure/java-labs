package refactoring.guru.proxy;

import java.util.HashMap;

public interface ThirdPartyInterface {
	HashMap<String, Video> popularVideos();

	Video getVideo(String videoId);
}