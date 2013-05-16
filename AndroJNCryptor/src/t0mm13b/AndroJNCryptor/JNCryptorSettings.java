package t0mm13b.AndroJNCryptor;

/**
 * Holder for settings to enable customization of encryption/decryption
 * @author t0mm13b
 *
 */
public class JNCryptorSettings {
	private int mRounds;
	
	
	
	/**
	 * Constructor with setting number of iterations for encryption
	 * @param iRounds - number of iterations.
	 */
	public JNCryptorSettings(int iRounds){
		this.mRounds = iRounds;
	}
	
	/**
	 * Getter field to access the number of iterations 
	 * @return number of iterations
	 */
	public int getRounds(){
		return this.mRounds;
	}
	
	/**
	 * Setter field to set up the iterations
	 * @param iRounds - number of iterations.
	 */
	public void setRounds(int iRounds){
		this.mRounds = iRounds;
	}

	@Override
  public int hashCode() {
	  final int prime = 31;
	  int result = 1;
	  result = prime * result + mRounds;
	  return result;
  }

	@Override
  public boolean equals(Object obj) {
	  if (this == obj) {
		  return true;
	  }
	  if (obj == null) {
		  return false;
	  }
	  if (!(obj instanceof JNCryptorSettings)) {
		  return false;
	  }
	  JNCryptorSettings other = (JNCryptorSettings) obj;
	  if (mRounds != other.mRounds) {
		  return false;
	  }
	  return true;
  }

	@Override
  public String toString() {
	  return "JNCryptorSettings [mRounds=" + mRounds + "]";
  }
	
	
}
