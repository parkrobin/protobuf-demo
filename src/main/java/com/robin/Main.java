package com.robin;

import com.robin.proto.PersonProtos.Person;
import com.robin.proto.PersonProtos.Person.PhoneNumber;
import com.robin.proto.PersonProtos.Person.PhoneType;
import com.google.protobuf.InvalidProtocolBufferException;

public class Main {
    public static void main(String[] args) {
        // Create a Person Builder
        Person.Builder personBuilder = Person.newBuilder();

        // Set fields
        personBuilder.setName("Robin")
                .setAge(22)
                .setEmail("parkrobin@example.com")
                .setAddress("777 Lexington");

        // Add phone number
        PhoneNumber.Builder phoneNumberBuilder = PhoneNumber.newBuilder()
                .setNumber("+1-123-456-7890")
                .setType(PhoneType.MOBILE);
        personBuilder.addPhones(phoneNumberBuilder);

        phoneNumberBuilder = PhoneNumber.newBuilder()
                .setNumber("+1-123-456-7891")
                .setType(PhoneType.HOME);
        personBuilder.addPhones(phoneNumberBuilder);

        // Build the Person message
        Person person = personBuilder.build();

        try {
            // Serialize to byte array
            byte[] serializedPerson = person.toByteArray();
            System.out.println("Serialized size: " + serializedPerson.length + " bytes");

            // Deserialize from byte array
            Person deserializedPerson = Person.parseFrom(serializedPerson);

            // Print the deserialized data
            System.out.println("\nDeserialized Person:");
            System.out.println("Name: " + deserializedPerson.getName());
            System.out.println("Age: " + deserializedPerson.getAge());
            System.out.println("Email: " + deserializedPerson.getEmail());
            System.out.println("Address: " + deserializedPerson.getAddress());

            System.out.println("\nPhone Numbers:");
            for (PhoneNumber phone : deserializedPerson.getPhonesList()) {
                System.out.printf("  %s (%s)%n",
                        phone.getNumber(),
                        phone.getType());
            }
          } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }
}