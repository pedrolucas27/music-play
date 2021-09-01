package classes;
import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class Track {

    private File track;
    private SourceDataLine line;
    private AudioInputStream din;
    private AudioFormat decodeFormat;
    
    public Track()
    {
        this.track = null;
        this.line = null;
        this.din = null;
    }

    public Track(File track)
    {
        try
        {
            //abre arquivo de audio
            this.track = track;
            //cria um strem de entrada do arquivo
            AudioInputStream ais = AudioSystem.getAudioInputStream(this.track);
            //seleciona o formato do arquivo de audio
            AudioFormat baseFormat = ais.getFormat();
            //configura a decodificação
            decodeFormat = new AudioFormat(
                AudioFormat.Encoding.PCM_SIGNED, // Encoding to use
                baseFormat.getSampleRate(),	  // sample rate (same as base format)
                16,				  // sample size in bits (thx to Javazoom)
                baseFormat.getChannels(),	  // # of Channels
                baseFormat.getChannels()*2,	  // Frame Size
                baseFormat.getSampleRate(),	  // Frame Rate
                false				  // Big Endian
            );

            din = AudioSystem.getAudioInputStream(decodeFormat, ais);
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, getDecodeFormat());
	    this.line = (SourceDataLine) AudioSystem.getLine(info);
        }
        catch(Exception e){}
    }

    public File getTrack() {
        return track;
    }

    public void setTrack(File track) {
        this.track = track;
    }

    public SourceDataLine getLine() {
        return line;
    }

    public void setLine(SourceDataLine line) {
        this.line = line;
    }

    public AudioInputStream getDin() {
        return din;
    }

    public void setDin(AudioInputStream din) {
        this.din = din;
    }

    public AudioFormat getDecodeFormat() {
        return decodeFormat;
    }

    public void setDecodeFormat(AudioFormat decodeFormat) {
        this.decodeFormat = decodeFormat;
    }
}