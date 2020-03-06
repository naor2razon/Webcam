/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcamproject;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamEvent;
import com.github.sarxos.webcam.WebcamListener;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author reuto
 */
public class WebcamScreenshot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
       
           Webcam webcam = Webcam.getDefault();
           
           webcam.addWebcamListener((new WebcamListener() {
               @Override
               public void webcamOpen(WebcamEvent we) {
                   System.out.println("Webcum Open"); 
               }

               @Override
               public void webcamClosed(WebcamEvent we) {
                   System.out.println("Webcum Close"); 
               }

               @Override
               public void webcamDisposed(WebcamEvent we) {
                   System.out.println("Webcum Disposed");
               }

               @Override
               public void webcamImageObtained(WebcamEvent we) {
                   System.out.println("Image Taken"); 
               }
           }));
           
           for(Dimension supportedSize: webcam.getViewSizes()){
               System.out.println(supportedSize.toString());
           }
           webcam.setViewSize(WebcamResolution.VGA.getSize());
           
           webcam.open();
           ImageIO.write(webcam.getImage(), "PNG", new File("first.png"));
           webcam.close();
    }
    
}
