/***
*
* Define Params Body Transfer by RPC
*
***/

namespace java Poseidon.ServiceDefine

enum ParamType{
    INT = 1,
    FLOAT = 2,
    BOOL = 3,
    STRING = 4,
    LIST = 10,
    MAP = 11
}
struct Param{
    1:ParamType type,
    2:string body,
}

struct Params{
    1:i32 num = 0,
    2:map<string,Param> paramsBody,
}

service ServiceCaller{
    Params INVOKE(1:Params params)
}