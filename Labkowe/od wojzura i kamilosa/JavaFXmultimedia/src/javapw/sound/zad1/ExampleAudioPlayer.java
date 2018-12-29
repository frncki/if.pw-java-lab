package javapw.sound.zad1;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


/**
 * This is an example program that demonstrates how to play back an audio file
 * using the Clip in Java Sound API.
 * based on example from  www.codejava.net
 */

public class ExampleAudioPlayer extends JFrame implements LineListener {
     
	String audioFilePath = "./resources/1-welcome.wav";
	Clip audioClip = null;
	File audioFile = null;
	AudioInputStream audioStream = null;
	String inFileName;
	
	
    boolean playCompleted = false;
    boolean startProgram = false;
    
    JButton startButton, stopButton, chooserButton;
    JFileChooser chooser;
	
    ExampleAudioPlayer(){
    	setSize(400,200);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setLocationRelativeTo(null);
    	
    	setLayout(new BorderLayout());
    	startButton = new JButton("Play");
    	startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!startProgram) {
					inFileName = "./resources/1-welcome.wav";
					play(inFileName);
					startProgram = true;
				} else {
					audioClip.start();
				}
				
			}
    		
    	});
    	
    	stopButton = new JButton("Stop");
    	stopButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				audioClip.stop();
				playCompleted = false;
				
			}
    		
    	});
    	
    	chooserButton = new JButton("Choose music file");
    	chooserButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				chooser = new JFileChooser("./resources/1-welcome.wav");
				chooser.setDialogTitle("Load File");
				int result = chooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					inFileName = chooser.getSelectedFile().getAbsolutePath();
					startProgram = false;
					playCompleted = false;
				} else {
					return;
				}
			}
     		
     	});
     	add(chooserButton, BorderLayout.NORTH);
    	add(startButton, BorderLayout.CENTER);
    	add(stopButton, BorderLayout.SOUTH);
    }
    
  
    /**
     * Play a given audio file.
     * @param audioFilePath Path of the audio file.
     */
    void play(String audioFilePath) {
    	
        try {
            audioFile = new File(audioFilePath);
            audioStream = AudioSystem.getAudioInputStream(audioFile);
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            audioClip = (Clip) AudioSystem.getLine(info);
            audioClip.addLineListener(this);
            audioClip.open(audioStream);
            
            /**
             *  Play the audio clip in a new thread not to block the GUI.
             *  It helps in this case, but is not really necessary. 
             */
            Thread thread = new Thread(new Runnable() {

                public void run() {
                	 audioClip.start();
     	            while(!playCompleted){          	
     	            	    	            	
     	            }
     	            audioClip.close();

     	            try {
 						audioStream.close();
 					} catch (IOException e) {
 				            e.printStackTrace();
 					}
                            
                }
                        
            });
            thread.start();
            
            

        } catch (UnsupportedAudioFileException ex) {
            System.out.println("The specified audio file is not supported.");
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            System.out.println("Audio line for playing back is unavailable.");
            ex.printStackTrace();
        } catch (IOException e1) {
            System.out.println("Error playing the audio file.");
			e1.printStackTrace();
		} 
         
    }
     
    /**
     * Listens to the START and STOP events of the audio line.
     */
    @Override
    public void update(LineEvent event) {
        LineEvent.Type type = event.getType();
         
        if (type == LineEvent.Type.START) {
            System.out.println("Playback started.");
             
        } else if (type == LineEvent.Type.STOP) {
            playCompleted = true;
            System.out.println("Playback completed.");
        }
 
    }
 
    public static void main(String[] args) {
    	
    	
    	 SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
		    	ExampleAudioPlayer p = new ExampleAudioPlayer();
		    	p.setVisible(true);
			}
		});
    }
 
}

