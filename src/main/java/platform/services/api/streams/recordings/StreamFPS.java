package platform.services.api.streams.recordings;

public enum StreamFPS {

    FPS_1(1),
    FPS_2(2),
    FPS_4(4),
    FPS_6(6),
    FPS_8(8),
    FPS_10(10),
    FPS_12(12),
    FPS_15(15),
    FPS_20(20),
    FPS_25(25),
    FPS_30(30);

    private final int fps;

    StreamFPS(final int fps) {

        this.fps = fps;

    }

}
