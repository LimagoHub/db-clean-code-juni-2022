package segments;

public class Segment {
    private final int startIndex;
    private final int segmentSize;

    public Segment(final int startIndex, final int segmentSize) {
        this.startIndex = startIndex;
        this.segmentSize = segmentSize;

    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getEndeIndex() {
        return startIndex + segmentSize;
    }

    public int getSegmentSize() {
        return segmentSize;
    }
}