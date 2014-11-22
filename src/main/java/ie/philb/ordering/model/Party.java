package ie.philb.ordering.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import java.lang.Override;
import ie.philb.ordering.model.Address;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Party implements Serializable
{

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id", updatable = false, nullable = false)
   private Long id;
   @Version
   @Column(name = "version")
   private int version;

   @Column
   private String name;

   @Column
   private String telephone;

   @Column
   private String email;

   @Column
   private String website;

   @Column
   private String taxcode;

   @OneToMany
   private Set<Address> address = new HashSet<Address>();

   public Long getId()
   {
      return this.id;
   }

   public void setId(final Long id)
   {
      this.id = id;
   }

   public int getVersion()
   {
      return this.version;
   }

   public void setVersion(final int version)
   {
      this.version = version;
   }

   @Override
   public boolean equals(Object obj)
   {
      if (this == obj)
      {
         return true;
      }
      if (!(obj instanceof Party))
      {
         return false;
      }
      Party other = (Party) obj;
      if (id != null)
      {
         if (!id.equals(other.id))
         {
            return false;
         }
      }
      return true;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      return result;
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public String getTelephone()
   {
      return telephone;
   }

   public void setTelephone(String telephone)
   {
      this.telephone = telephone;
   }

   public String getEmail()
   {
      return email;
   }

   public void setEmail(String email)
   {
      this.email = email;
   }

   public String getWebsite()
   {
      return website;
   }

   public void setWebsite(String website)
   {
      this.website = website;
   }

   public String getTaxcode()
   {
      return taxcode;
   }

   public void setTaxcode(String taxcode)
   {
      this.taxcode = taxcode;
   }

   @Override
   public String toString()
   {
      String result = getClass().getSimpleName() + " ";
      if (name != null && !name.trim().isEmpty())
         result += "name: " + name;
      if (telephone != null && !telephone.trim().isEmpty())
         result += ", telephone: " + telephone;
      if (email != null && !email.trim().isEmpty())
         result += ", email: " + email;
      if (website != null && !website.trim().isEmpty())
         result += ", website: " + website;
      if (taxcode != null && !taxcode.trim().isEmpty())
         result += ", taxcode: " + taxcode;
      return result;
   }

   public Set<Address> getAddress()
   {
      return this.address;
   }

   public void setAddress(final Set<Address> address)
   {
      this.address = address;
   }
}