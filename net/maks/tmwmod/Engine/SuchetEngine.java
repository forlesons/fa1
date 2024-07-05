package net.maks.tmwmod.Engine;

import io.netty.util.Attribute;
import net.maks.tmwmod.TmwMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.Camera;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.concurrent.TimeUnit;

public class SuchetEngine {
    static Minecraft minecraft = Minecraft.getInstance();
    static LocalPlayer player = minecraft.player;

    static int nowTick = 0;

    public static void tpPlayer(double x, float y, double z) {
        Entity camera = minecraft.cameraEntity;

        camera.setPos(x, y, z);
    }

    public static int setPlawXCam(int yCam1, int yCam2, double speed) throws InterruptedException {
        Entity camera = minecraft.cameraEntity;

        int rotXCam = yCam1;
        //4 tick

        if (TmwMod.nowTick == 4) {
            System.out.print("nice");
            if (yCam1 > yCam2) {
                if (rotXCam > yCam2) {
                    camera.setXRot(rotXCam);
                    camera.xRotO = rotXCam;

                    rotXCam -= speed;
                }
            }
            else if (yCam1 < yCam2) {
                if (rotXCam < yCam2) {
                    camera.setXRot(rotXCam);
                    camera.xRotO = rotXCam;

                    rotXCam += speed;
                }
            }
            else { return 1; }
        }
        return 0;
    }
}
