package pl.grzegorz2047.nukkitsurvivalgames.spawns;

import cn.nukkit.Server;
import cn.nukkit.level.Location;

/**
 * Plik stworzony przez grzegorz2047 01.04.2017.
 */

public class SpawnPoint {

    private double pitch;
    private double yaw;
    private double x, y, z;
    private String worldName;
    private boolean free = true;
    private String occupiedBy;


    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free, String occupiedBy) {
        this.free = free;
        this.occupiedBy = occupiedBy;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public SpawnPoint(double x, double y, double z, double pitch, double yaw, String worldName) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.pitch = pitch;
        this.yaw = yaw;
        this.worldName = worldName;
    }

    public String getOccupiedBy() {
        return occupiedBy;
    }

    public void setOccupiedBy(String occupiedBy) {
        this.occupiedBy = occupiedBy;
        this.free = false;
    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public String getWorldName() {
        return worldName;
    }

    public void setWorldName(String worldName) {
        this.worldName = worldName;
    }

    public Location getLocation() {
        return new Location(x, y, z, Server.getInstance().getLevelByName(this.worldName));
    }

    public double getPitch() {
        return pitch;
    }

    public double getYaw() {
        return yaw;
    }
}

