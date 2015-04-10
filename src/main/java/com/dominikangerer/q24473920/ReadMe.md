#Question
Link: http://stackoverflow.com/q/24473920/1581725

#Answer
Link: http://stackoverflow.com/a/24474798/1581725

    public void playerProfileExists(Player player) throws SQLException {
        final String queryCheck = "SELECT * FROM `playerdata` WHERE player = ?";
        if(player != null){
            PreparedStatement ps = c.prepareStatement(queryCheck);
            ps.setString(1, player.getName());
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                String name = resultSet.getString("player");
                System.out.println("Player " + name + " exists!");
            }
            else{
                System.out.println("Player doesn't exist");
            }
        }
    }

Try it like that - also - you don't have to make every variable `final` - only makes sense for the `queryCheck`-String because this won't.

if `resultSet.next()` wouldn't give you a result -> there is no player. Also check if the `player` you get is not `null` so you can't get a `NullPointerException`.
