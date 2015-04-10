# Question:
Link: http://stackoverflow.com/q/29550820/1581725

# Answer:
Link: http://stackoverflow.com/a/29550948/1581725
Instead of using 2 separate classes (`Shirt` and `Pants`) simply use one class - let's say `Cloth`. Tried it like that and worked fine:

**Person class:**
    
    package com.dominikangerer.q29550820;

    public class Person {
    	private String name;
    	private String lastName;
    	private Clothes clothes;
    }

**Clothes class:**

    package com.dominikangerer.q29550820;

    public class Clothes {
    	private String gender;
    	private Cloth Shirt;
    	private Cloth Pants;    	
    }

**Cloth class:**

    package com.dominikangerer.q29550820;
    
    public class Cloth {
    	private Integer id;
    	private String name;
    	private String size;
    }

After Building these classes I tried it directly in a little main class which results in a perfectly fine deserialized.

    Gson g = new Gson();
    Person person = g.fromJson("{\"name\":\"Jhon\",\"lastName\":\"Smith\",\"clothes\":{\"gender\":\"male\",\"Shirt\":{\"id\":113608,\"name\":\"Green Shirt\",\"size\":\"Large\"},\"Pants\":{\"id\":115801,\"name\":\"Black Leather Pants\",\"size\":\"Large\"}}}", Person.class);
		
Didn't use `@Expose` here or `@SerializedName("something")` because it wasn't needed.

Hope it helps you out - otherwise please explain your problem in more detail and I will try to help you.

**----------- Update ------------**

Okay normally it's quite easy to cast a Json as you have it there in an normal `Object` - but the thing is inside the map (`clothes`) you have also a normal `String` value. For this purpose I would suggest you to enable the `Gson` functionality `@Expose` I will tell you why this would be a good idea later.

Let's start:
I removed the `Clothes` class with a `Map<String, Object>` which `Gson` can easily deserialize - problem here was that the we also have the gender inside that map. I modified the Person class which now works like this:

**Person v2:**

    package com.dominikangerer.q29550820;

    public class Person {
    	private String name;
    
    	private String lastName;
    
    	@SerializedName("clothes")
    	private Map<String, Object> clothesWrapper;
    
    	public String getGender() {
    		return clothesWrapper.get("gender").toString();
    	}
    
    	public void setGender(String gender) {
    		this.clothesWrapper.put("gender", gender);
    	}
    }

Now we can already map the `gender` as `String` and modify it with the getter and setter - still have the map up there which contains `Object`s. Next thing we don't want the `Map<String, Object>` - for deserializing and serialization it's totally fine - but for working with the `Cloth`s itself - it's stupid so let's get rid of it with the easiest way:

We modify our Person class like this:

**Person v3:**

    package com.dominikangerer.q29550820;

    public class Person {
    	@Expose
    	private String name;
    
    	@Expose
    	private String lastName;
    
    	@Expose
    	@SerializedName("clothes")
    	private Map<String, Object> clothesWrapper;
    
    	private Map<String, Cloth> clothes;
    
    	public String getGender() {
    		return clothesWrapper.get("gender").toString();
    	}
    
    	public void setGender(String gender) {
    		this.clothesWrapper.put("gender", gender);
    	}
    
    	public Map<String, Cloth> getClothes() {
    		if (clothes == null) {
                Gson g = new Gson();
    			clothes = new HashMap<String, Cloth>();
    			for (Entry<String, Object> entry : clothesWrapper.entrySet()) {
    				if (entry.getKey().equals("gender")) {
    					continue;
    				}
    				String helper = g.toJson(entry.getValue());
    				Cloth cloth = g.fromJson(helper, Cloth.class);
    				clothes.put(entry.getKey(), cloth);
    			}
    		}
    		return clothes;
    	}
    }

As you can see we now indirectly cast all the `Cloth`es - we have to do this like that because it's the easiest way to get all the `LinkedTreeMap` to a `Cloth`-`Object` without running into a `ClassCastException`. As you can see we now have a `Map<String,Object> clothesWrapper` which let Gson Parse the object (can't find a better name - sorry) and the `Map<String, Cloth> clothes` map without Expose. Now you also need to setup the Gson with the enableExpose option which works like this:

(Using the Person v3 Class here - simply debug into it - works like a charm)

    public class Main {
    	public static void main(String[] args) {
    		Gson g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    		Person person = g.fromJson("{\"name\":\"Jhon\",\"lastName\":\"Smith\",\"clothes\":{\"gender\":\"male\",\"Shirt\":{\"id\":113608,\"name\":\"Green Shirt\",\"size\":\"Large\"},\"Pants\":{\"id\":115801,\"name\":\"Black Leather Pants\",\"size\":\"Large\"}}}", Person.class);
    		System.out.println(person.getClothes());
            System.out.println(person.getGender());
    	}
    }