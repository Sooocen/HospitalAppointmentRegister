import request from '@/utils/request'


export default{
    //通过ID查询数据字典列表
    getCmnByid(id){
        return request({
            url: `/admin/cmn/dict/findChildData/${id}`,
            method: 'get'
          })
      },

}