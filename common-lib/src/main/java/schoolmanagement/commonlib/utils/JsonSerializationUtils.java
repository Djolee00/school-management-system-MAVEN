package schoolmanagement.commonlib.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonSerializationUtils {

	/**
	 * The shared instance of the ObjectMapper class used for JSON serialization and
	 * deserialization. JavaTimeModule is used to allow work with Java 8 date types like LocalDate
	 */
	private static final ObjectMapper objectMapper  = new ObjectMapper().registerModule(new JavaTimeModule());

	/**
	 * Private constructor to prevent instantiation of the utility class.
	 */
	private JsonSerializationUtils() {
	}

	/**
	 * Serializes the given source object to JSON.
	 *
	 * @param source     The object to serialize.
	 * @param targetType The type reference representing the target type.
	 * @param <T>        The type of the source object.
	 * @return The JSON representation of the source object as a string.
	 * @throws JsonProcessingException
	 */
	public static <T> String serializeToJson(T source, TypeReference<T> targetType) throws JsonProcessingException {
		return objectMapper.writerFor(targetType).writeValueAsString(source);
	}

	/**
	 * Deserializes the given JSON string to an object of the specified target type.
	 *
	 * @param source The JSON string to deserialize.
	 * @param target The type reference representing the target type.
	 * @param <T>    The type of the target object.
	 * @return The deserialized object of the specified target type.
	 * @throws JsonProcessingException If an error occurs during deserialization
	 * @throws JsonMappingException
	 */
	public static <T> T deserializeFromJson(String source, TypeReference<T> target)
			throws JsonMappingException, JsonProcessingException {
		return objectMapper.readValue(source, target);
	}
}
