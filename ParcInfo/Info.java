package info;
public class Info{
    public String getNameOs(){
        return System.getProperty("os.name");
    }
    public String getArchitectureOs(){
        return System.getProperty("os.arch");
    }
    public String getVersionOs(){
        return System.getProperty("os.version");
    }
    public String getNameUser(){
        return System.getProperty("user.name");
    }
    public String getUserHome(){
        return System.getProperty("user.home");
    }

    public long getMaxMemory(){
        Runtime rn=Runtime.getRuntime();
        long max=rn.maxMemory();
        return max;
    }
    public long getFreeMemory(){
        Runtime rn=Runtime.getRuntime();
        long free=rn.freeMemory();
        return free;
    }
    public long getUsedMemory(){
        Runtime rn=Runtime.getRuntime();
        long utilise=getMaxMemory()-getFreeMemory();
        return utilise;       
    }
    public String getGeneralInfo(){
        String info="";
        info="OS:"+getNameOs()+"///";
        info=info.concat(getArchitectureOs()+"///");
        info=info.concat(getVersionOs()+"///");
        info=info.concat(getNameUser()+"///");
        info=info.concat(getMaxMemory()+"///");
        info=info.concat(getFreeMemory()+"///");
        info=info.concat(getUsedMemory()+"///");
        return info;
    }
}