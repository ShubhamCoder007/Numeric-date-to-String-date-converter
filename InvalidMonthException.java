class InvalidMonthException extends Throwable
{
    private String msg;
    
    public InvalidMonthException(){
        this("That's an invalid month!");
    }
    
    public InvalidMonthException(String msg){
        super(msg);
        this.msg=msg;
    }
    
    public String getMessage(){
        return msg;
    }
}
        