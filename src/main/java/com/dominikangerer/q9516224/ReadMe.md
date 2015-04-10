#Question
Link: http://stackoverflow.com/q/9516224/1581725

#Answer
Link: http://stackoverflow.com/a/26829468/1581725

You can find a fully working example here: https://github.com/DominikAngerer/java-GsonJerseyProvider

There will be an working implementation of http://eclipsesource.com/blogs/2012/11/02/integrating-gson-into-a-jax-rs-based-application/ but with some new achievements - like an `GsonUtil` for `Expose` only things.


    @Provider
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public class GsonJerseyProvider implements MessageBodyWriter<Object>,
    		MessageBodyReader<Object> {
    
    	private static final String UTF_8 = "UTF-8";
    
    	@Override
    	public boolean isReadable(Class<?> type, Type genericType,
    			java.lang.annotation.Annotation[] annotations, MediaType mediaType) {
    		return true;
    	}
    
    	@Override
    	public Object readFrom(Class<Object> type, Type genericType,
    			Annotation[] annotations, MediaType mediaType,
    			MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
    			throws IOException {
    		InputStreamReader streamReader = new InputStreamReader(entityStream,
    				UTF_8);
    		try {
    			Type jsonType;
    			if (type.equals(genericType)) {
    				jsonType = type;
    			} else {
    				jsonType = genericType;
    			}
    			return GsonUtil.getInstance()
    					.fromJson(streamReader, jsonType);
    		} catch (com.google.gson.JsonSyntaxException e) {
    			// Log exception
    		} finally {
    			streamReader.close();
    		}
    		return null;
    	}
    
    	@Override
    	public boolean isWriteable(Class<?> type, Type genericType,
    			Annotation[] annotations, MediaType mediaType) {
    		return true;
    	}
    
    	@Override
    	public long getSize(Object object, Class<?> type, Type genericType,
    			Annotation[] annotations, MediaType mediaType) {
    		return -1;
    	}
    
    	@Override
    	public void writeTo(Object object, Class<?> type, Type genericType,
    			Annotation[] annotations, MediaType mediaType,
    			MultivaluedMap<String, Object> httpHeaders,
    			OutputStream entityStream) throws IOException,
    			WebApplicationException {
    		OutputStreamWriter writer = new OutputStreamWriter(entityStream, UTF_8);
    		try {
    			Type jsonType;
    			if (type.equals(genericType)) {
    				jsonType = type;
    			} else {
    				jsonType = genericType;
    			}
    			GsonUtil.getInstance().toJson(object, jsonType, writer);
    		} finally {
    			writer.close();
    		}
    	}
    }