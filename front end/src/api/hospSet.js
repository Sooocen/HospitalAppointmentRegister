import request from '@/utils/request'

// export function getHospitalset(current,limit,searchObj) {
//     return request({
//       url: `/admin/hosp/hospitalSet/findPage/${current}/${limit}`,
//       method: 'post',
//       date : searchObj
//     })
//   }

  export default{
      //获取医院设置
     getHospitalset(current,limit,searchObj) {
        return request({
        //   url: `/admin/hosp/hospitalSet/findPage/${current}/${limit}`,
          url: `/admin/hosp/hospitalSet/findPage/${current}/${limit}`,
          method: 'post',
          data: searchObj
        })
      },
      //删除医院设置
      deleteHospitalSet(id){
        return request({
            url: `/admin/hosp/hospitalSet/deleteHospitalSet/${id}`,
            method: 'delete'
          })
      },
      //批量删除医院设置
      batchDeleteHospitalSet(idlist){
        return request({
            url: `/admin/hosp/hospitalSet/BatchRemoveHospitalSet`,
            method: 'delete',
            data: idlist
          })
      },
      //医院设置锁定/解锁
      lockHospitalSet(id,status){
        return request({
            url: `/admin/hosp/hospitalSet/lockHospitalSet/${id}/${status}`,
            method: 'put'
          })
      },
      //添加医院设置
      addHospitalSet(hospitalSet){
        return request({
            url: `/admin/hosp/hospitalSet/saveHospitalSet`,
            method: 'post',
            data: hospitalSet
          })
      },
      //通过ID查询医院设置
      getHospitalSetByID(id){
        return request({
            url: `/admin/hosp/hospitalSet/getHospitalSet/${id}`,
            method: 'get'
          })
      },
      //修改医院设置 updateHospitalSet
      updateHospitalSet(hospitalSet){
        return request({
            url: `/admin/hosp/hospitalSet/updateHospitalSet`,
            method: 'post',
            data: hospitalSet
          })
      }
  }