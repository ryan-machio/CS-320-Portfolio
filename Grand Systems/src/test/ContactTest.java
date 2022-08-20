package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contactservice.Contact;

public class ContactTest {
  protected String contactId, firstNameTest, lastNameTest, phoneNumberTest,
      addressTest;
  protected String contactIdLong, firstNameLong, lastNameLong,
      phoneNumberLong, phoneNumberShort, addressTooLong;

  @BeforeEach
  void setUp() {
    contactId = "1229F847B6";
    firstNameTest = "Ryan";
    lastNameTest = "Manchan";
    phoneNumberTest = "7636072447";
    addressTest = "S1 Audrey Jersey City NJ 07305";
    contactIdLong = "112233445566778899";
    firstNameLong = "Ryan Manchanthasouk";
    lastNameLong = "-Manchanthasouk";
    phoneNumberLong = "55512341234";
    phoneNumberShort = "1234567";
    addressTooLong = "1 Audrey Zapp Drive, Jersey City, NJ 07305";
  }

  @Test
  void contactTest() {
    Contact contact = new Contact();
    assertAll("constructor",
              ()
                  -> assertNotNull(contact.getContactId()),
              ()
                  -> assertNotNull(contact.getFirstName()),
              ()
                  -> assertNotNull(contact.getLastName()),
              ()
                  -> assertNotNull(contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test
  void contactIdConstructorTest() {
    Contact contact = new Contact(contactId);
    assertAll("constructor one",
              ()
                  -> assertEquals(contactId, contact.getContactId()),
              ()
                  -> assertNotNull(contact.getFirstName()),
              ()
                  -> assertNotNull(contact.getLastName()),
              ()
                  -> assertNotNull(contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test
  void contactIdAndFirstNameConstructorTest() {
    Contact contact = new Contact(contactId, firstNameTest);
    assertAll("constructor two",
              ()
                  -> assertEquals(contactId, contact.getContactId()),
              ()
                  -> assertEquals(firstNameTest, contact.getFirstName()),
              ()
                  -> assertNotNull(contact.getLastName()),
              ()
                  -> assertNotNull(contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test
  void contactIdAndFullNameConstructorTest() {
    Contact contact = new Contact(contactId, firstNameTest, lastNameTest);
    assertAll("constructor three",
              ()
                  -> assertEquals(contactId, contact.getContactId()),
              ()
                  -> assertEquals(firstNameTest, contact.getFirstName()),
              ()
                  -> assertEquals(lastNameTest, contact.getLastName()),
              ()
                  -> assertNotNull(contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test
  void contactIdFullNamePhoneNumberConstructorTest() {
    Contact contact =
        new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest);
    assertAll("constructor four",
              ()
                  -> assertEquals(contactId, contact.getContactId()),
              ()
                  -> assertEquals(firstNameTest, contact.getFirstName()),
              ()
                  -> assertEquals(lastNameTest, contact.getLastName()),
              ()
                  -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test
  void allTheProperThingsConstructorTest() {
    Contact contact = new Contact(contactId, firstNameTest, lastNameTest,
                                  phoneNumberTest, addressTest);
    assertAll("constructor all",
              ()
                  -> assertEquals(contactId, contact.getContactId()),
              ()
                  -> assertEquals(firstNameTest, contact.getFirstName()),
              ()
                  -> assertEquals(lastNameTest, contact.getLastName()),
              ()
                  -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
              () -> assertEquals(addressTest, contact.getAddress()));
  }

  @Test
  void updateFirstNameTest() {
    Contact contact = new Contact();
    contact.updateFirstName(firstNameTest);
    assertAll(
        "first name",
        ()
            -> assertEquals(firstNameTest, contact.getFirstName()),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateFirstName(null)),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateFirstName(firstNameLong)));
  }

  @Test
  void updateLastNameTest() {
    Contact contact = new Contact();
    contact.updateLastName(lastNameTest);
    assertAll(
        "last name",
        ()
            -> assertEquals(lastNameTest, contact.getLastName()),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateLastName(null)),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateLastName(firstNameLong)));
  }

  @Test
  void updatePhoneNumberTest() {
    Contact contact = new Contact();
    contact.updatePhoneNumber(phoneNumberTest);
    assertAll("phone number",
              ()
                  -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
              ()
                  -> assertThrows(IllegalArgumentException.class,
                                  () -> contact.updatePhoneNumber(null)),
              ()
                  -> assertThrows(
                      IllegalArgumentException.class,
                      () -> contact.updatePhoneNumber(phoneNumberLong)),
              ()
                  -> assertThrows(
                      IllegalArgumentException.class,
                      () -> contact.updatePhoneNumber(phoneNumberShort)),
              ()
                  -> assertThrows(IllegalArgumentException.class,
                                  () -> contact.updatePhoneNumber(contactId)));
  }

  @Test
  void updateAddressTest() {
    Contact contact = new Contact();
    contact.updateAddress(addressTest);
    assertAll("phone number",
              ()
                  -> assertEquals(addressTest, contact.getAddress()),
              ()
                  -> assertThrows(IllegalArgumentException.class,
                                  () -> contact.updateAddress(null)),
              ()
                  -> assertThrows(IllegalArgumentException.class,
                                  () -> contact.updateAddress(addressTooLong)));
  }

  @Test
  void updateContactIdTest() {
    Contact contact = new Contact();
    contact.updateContactId(contactId);
    assertAll(
        "contact ID",
        ()
            -> assertEquals(contactId, contact.getContactId()),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateContactId(null)),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateContactId(contactIdLong)));
  }
}