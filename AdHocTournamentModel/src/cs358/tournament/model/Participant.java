package cs358.tournament.model;
/**
 * Participant - a tournament participant who will play on a team in a bracket
 * 
 * @author richardtj
 *
 */
public class Participant {

  private String mFirstName;
  private String mLastName;
  private String mOrganization;
  
  /**
   * Constructor
   * @param first first name of the participant
   * @param last last name of the participant
   * @param organization organization in which the participant belongs
   */
  public Participant(String first, String last, String organization) {
    mFirstName = first;
    mLastName = last;
    mOrganization = organization;
  }
  
  /**
   * setOrganization - allows participant to change organizations
   * 
   * @param organization organization in which the participant belongs
   */
  public void setOrganization(String organization) {
    mOrganization = organization;
  }
  
  /**
   * getFirstName
   * @return first name
   */
  public String getFirstName() {
    return mFirstName;
  }
  
  /**
   * getLastName
   * @return last name
   */
  public String getLastName() {
    return mLastName;
  }
  
  /**
   * getOrganization
   * @return organization
   */
  public String getOrganization() {
    return mOrganization;
  }
  
  @Override
  public boolean equals(Object o) {
      // self check
      if (this == o)
          return true;
      // null check
      if (o == null)
          return false;
      // type check and cast
      if (getClass() != o.getClass())
          return false;
      Participant player = (Participant) o;
      // field comparison
      return mFirstName.equals(player.mFirstName)
              &&  mLastName.equals(player.mLastName)
              &&  mOrganization.equals(player.mOrganization);
  }
  
}
