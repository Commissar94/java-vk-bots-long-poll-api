package api.longpoll.bots.model.objects.media;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

/**
 * Describes document.
 *
 * @see <a href="https://vk.com/dev/objects/doc">Document</a>
 */
public class Doc implements Attachable {
    /**
     * Document ID.
     */
    @SerializedName("id")
    private Integer id;

    /**
     * ID of the user who uploaded the document.
     */
    @SerializedName("owner_id")
    private Integer ownerId;

    /**
     * Document title.
     */
    @SerializedName("title")
    private String title;

    /**
     * Document size (in bytes).
     */
    @SerializedName("size")
    private Integer size;

    /**
     * Document extension.
     */
    @SerializedName("ext")
    private String ext;

    /**
     * Document URL for downloading.
     */
    @SerializedName("url")
    private String url;

    /**
     * Date when the document has been added in Unixtime
     */
    @SerializedName("date")
    private Integer date;

    /**
     * Document type. Possible values:
     * <ol>
     *     <li>1 — text documents;</li>
     *     <li>2 — archives;</li>
     *     <li>3 — gif;</li>
     *     <li>4 — images;</li>
     *     <li>5 — audio;</li>
     *     <li>6 — video;</li>
     *     <li>7 — e-books;</li>
     *     <li>8 — unknown.</li>
     * </ol>
     */
    @SerializedName("type")
    private Integer type;

    /**
     * Document preview data.
     */
    @SerializedName("preview")
    private Map<String, Preview> preview;

    /**
     * Document access key.
     */
    @SerializedName("access_key")
    private String accessKey;

    /**
     * Describes document preview data.
     */
    public interface Preview {
    }

    /**
     * Describes document photo preview data.
     */
    public static class Photo implements Preview {
        /**
         * Array with the photo copies of different sizes.
         */
        @SerializedName("sizes")
        private List<Size> sizes;

        /**
         * Describes photo size.
         */
        public static class Size {
            /**
             * Photo URL.
             */
            @SerializedName("src")
            private String src;

            /**
             * Photo width in pixels.
             */
            @SerializedName("width")
            private Integer width;

            /**
             * Photo height in pixels.
             */
            @SerializedName("height")
            private Integer height;

            /**
             * Photo preview type. Possible values:
             * <ul>
             * <li><b>s</b> — proportional copy with max side of 100 px;</li>
             * <li><b>m</b> — proportional copy with max side of 130 px;</li>
             * <li><b>x</b> — proportional copy with max side of 604 px;</li>
             * <li><b>y</b> — proportional copy with max side of 807 px;</li>
             * <li><b>z</b> — proportional copy with max size of 1080x1024 px;</li>
             * <li><b>o</b> — original size image.</li>
             * </ul>
             */
            @SerializedName("type")
            private String type;

            public String getSrc() {
                return src;
            }

            public void setSrc(String src) {
                this.src = src;
            }

            public Integer getWidth() {
                return width;
            }

            public void setWidth(Integer width) {
                this.width = width;
            }

            public Integer getHeight() {
                return height;
            }

            public void setHeight(Integer height) {
                this.height = height;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }

        public List<Size> getSizes() {
            return sizes;
        }

        public void setSizes(List<Size> sizes) {
            this.sizes = sizes;
        }
    }

    /**
     * Describes document graffiti preview data.
     */
    public static class Graffiti implements Preview {
        /**
         * Doc URL with graffiti
         */
        @SerializedName("src")
        private String src;

        /**
         * VideoImage width in pixels.
         */
        @SerializedName("width")
        private Integer width;

        /**
         * VideoImage height in pixels.
         */
        @SerializedName("height")
        private Integer height;

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }
    }

    /**
     * Describes document audio message preview data.
     */
    public static class AudioMessage implements Preview {
        /**
         * Audio message duration in seconds.
         */
        @SerializedName("duration")
        private Integer duration;
        /**
         * List of integers to visualize the sound.
         */
        @SerializedName("waveform")
        private List<Integer> waveform;
        /**
         * .ogg file URL.
         */
        @SerializedName("link_ogg")
        private String linkOgg;
        /**
         * .mp3 file URL.
         */
        @SerializedName("link_mp3")
        private String linkMp3;

        public Integer getDuration() {
            return duration;
        }

        public void setDuration(Integer duration) {
            this.duration = duration;
        }

        public List<Integer> getWaveform() {
            return waveform;
        }

        public void setWaveform(List<Integer> waveform) {
            this.waveform = waveform;
        }

        public String getLinkOgg() {
            return linkOgg;
        }

        public void setLinkOgg(String linkOgg) {
            this.linkOgg = linkOgg;
        }

        public String getLinkMp3() {
            return linkMp3;
        }

        public void setLinkMp3(String linkMp3) {
            this.linkMp3 = linkMp3;
        }
    }

    /**
     * Describes document video preview data.
     */
    public static class Video implements Preview {
        /**
         * Video link.
         */
        @SerializedName("src")
        private String src;

        /**
         * Video width.
         */
        @SerializedName("width")
        private Integer width;

        /**
         * Video height.
         */
        @SerializedName("height")
        private Integer height;

        /**
         * Video size in bytes.
         */
        @SerializedName("file_size")
        private Integer fileSize;

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public Integer getFileSize() {
            return fileSize;
        }

        public void setFileSize(Integer fileSize) {
            this.fileSize = fileSize;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Map<String, Preview> getPreview() {
        return preview;
    }

    public void setPreview(Map<String, Preview> preview) {
        this.preview = preview;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }
}
