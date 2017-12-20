package kz.kbtu.informationcollector.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aibekkuralbaev on 20.12.2017.
 */

public class HardwareInfo {


    @SerializedName("serial_number")
    private String serialNumber;

    @SerializedName("model")
    private String model;

    @SerializedName("id")
    private String id;

    @SerializedName("manufacturer")
    private String manufacturer;

    @SerializedName("brand")
    private String brand;

    @SerializedName("type")
    private String type;

    @SerializedName("user")
    private String user;

    @SerializedName("code_base")
    private int codeBase;

    @SerializedName("version_incremental")
    private String versionIncremental;

    @SerializedName("version_sdk")
    private String versionSdk;

    @SerializedName("board")
    private String board;

    @SerializedName("host")
    private String host;

    @SerializedName("fingerprint")
    private String fingerprint;

    @SerializedName("version_release")
    private String versionRelease;



    protected HardwareInfo() {
    }

    private HardwareInfo(String serialNumber, String model, String id, String manufacturer, String brand, String type, String user, int codeBase, String versionIncremental, String versionSdk, String board, String host, String fingerprint, String versionRelease) {
        this.serialNumber = serialNumber;
        this.model = model;
        this.id = id;
        this.manufacturer = manufacturer;
        this.brand = brand;
        this.type = type;
        this.user = user;
        this.codeBase = codeBase;
        this.versionIncremental = versionIncremental;
        this.versionSdk = versionSdk;
        this.board = board;
        this.host = host;
        this.fingerprint = fingerprint;
        this.versionRelease = versionRelease;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getModel() {
        return model;
    }

    public String getId() {
        return id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public String getUser() {
        return user;
    }

    public int getCodeBase() {
        return codeBase;
    }

    public String getVersionIncremental() {
        return versionIncremental;
    }

    public String getVersionSdk() {
        return versionSdk;
    }

    public String getBoard() {
        return board;
    }

    public String getHost() {
        return host;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public String getVersionRelease() {
        return versionRelease;
    }


    public static HardwareInfoBuilder builder() {
        return new HardwareInfoBuilder();
    }


    public static class HardwareInfoBuilder {

        private String serialNumber;
        private String model;
        private String id;
        private String manufacturer;
        private String brand;
        private String type;
        private String user;
        private int codeBase;
        private String versionIncremental;
        private String versionSdk;
        private String board;
        private String host;
        private String fingerprint;
        private String versionRelease;


        public HardwareInfoBuilder setSerialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }

        public HardwareInfoBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public HardwareInfoBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public HardwareInfoBuilder setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }

        public HardwareInfoBuilder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public HardwareInfoBuilder setType(String type) {
            this.type = type;
            return this;
        }

        public HardwareInfoBuilder setUser(String user) {
            this.user = user;
            return this;
        }

        public HardwareInfoBuilder setCodeBase(int codeBase) {
            this.codeBase = codeBase;
            return this;
        }

        public HardwareInfoBuilder setVersionIncremental(String versionIncremental) {
            this.versionIncremental = versionIncremental;
            return this;
        }

        public HardwareInfoBuilder setVersionSdk(String versionSdk) {
            this.versionSdk = versionSdk;
            return this;
        }

        public HardwareInfoBuilder setBoard(String board) {
            this.board = board;
            return this;
        }

        public HardwareInfoBuilder setHost(String host) {
            this.host = host;
            return this;
        }

        public HardwareInfoBuilder setFingerprint(String fingerprint) {
            this.fingerprint = fingerprint;
            return this;
        }

        public HardwareInfoBuilder setVersionRelease(String versionRelease) {
            this.versionRelease = versionRelease;
            return this;
        }


        public HardwareInfo build() {
            return new HardwareInfo(serialNumber, model, id, manufacturer, brand, type, user, codeBase, versionIncremental, versionSdk, board, host, fingerprint, versionRelease);
        }
    }
}
