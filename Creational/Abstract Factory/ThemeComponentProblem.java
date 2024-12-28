import java.util.*;
import java.lang.*;
import java.io.*;
// JAI SHRI RAM 

interface Button
{
    public void render(); 
}

class DarkButton implements Button{
    @Override
    public void render()
    {
        System.out.println("Rendering Dark Button"); 
    }
}

class LightButton implements Button{
    @Override
    public void render()
    {
        System.out.println("Rendering Light Button"); 
    }
}

interface Textfield
{
    public void render(); 
}

class DarkTextField implements Textfield{
    @Override
    public void render()
    {
        System.out.println("Rendering Dark TextField"); 
    }
}

class LightTextField implements Textfield{
    @Override
    public void render()
    {
        System.out.println("Rendering Light TextField");
    }
}

class ComponentFactory
{
    private Button button; 
    private Textfield textField; 
    
    
    public void renderButton(String mode) throws java.lang.Exception
    {
        if(mode.equals("Dark")){
            button = new DarkButton();
        }
        else if(mode.equals("Light")){
            System.out.println("Light");
            button = new LightButton(); 
        }
        else
            throw new Exception("Button type doesn't exist"); 
        
        button.render(); 
    }
    public void renderTextField(String mode) throws java.lang.Exception
    {
        if(mode.equals("Dark"))
            textField = new DarkTextField(); 
        else if(mode.equals("Light"))
            textField = new LightTextField(); 
        else
            throw new Exception("TextField type doesn't exist");
        
        textField.render(); 
    }
}

class UIFactory
{
    ComponentFactory cf = new ComponentFactory(); 
    public void renderComponent(String comp, String mode) throws java.lang.Exception
    {
        if(comp.equals("Button"))
        { 
            cf.renderButton(mode);
        }
        else if(comp.equals("Textfield"))
            cf.renderTextField(mode); 
        else
            throw new Exception("Component type doesnt exist");
    }
}

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        try{
            UIFactory ui = new UIFactory(); 
            ui.renderComponent("Button", "Light"); 
            ui.renderComponent("Textfield", "Dark"); 
            ui.renderComponent("wront", "trwon");
        }
        catch(Exception ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
	}
}
