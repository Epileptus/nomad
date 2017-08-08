import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
public class UserList extends ArrayList<User> {

    public UserList(User user){
        super();
        add(user);
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for(int i=0 ; i<size() ; i++){
            result.append(get(i));
            if(i!=size()-1)
                result.append(", ");
        }
        return result.toString();
    }
}
