/* tslint:disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpHeaders } from '@angular/common/http';
import { BaseService as __BaseService } from '../base-service';
import { ApiConfiguration as __Configuration } from '../api-configuration';
import { StrictHttpResponse as __StrictHttpResponse } from '../strict-http-response';
import { Observable as __Observable } from 'rxjs';
import { map as __map, filter as __filter } from 'rxjs/operators';

import { Privilege } from '../models/privilege';

/**
 * Privilege Management Controller Impl
 */
@Injectable({
  providedIn: 'root',
})
class PrivilegeManagementControllerImplService extends __BaseService {
  static readonly getPrivilegesUsingGETPath = '/privileges';
  static readonly addPrivilegeUsingPOSTPath = '/privileges/add';
  static readonly deletePrivilegeUsingGETPath = '/privileges/delete/{name}';
  static readonly getPrivilegesForRoleUsingGETPath = '/privileges/forRole/{roleName}';

  constructor(
    config: __Configuration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * @return OK
   */
  getPrivilegesUsingGETResponse(): __Observable<__StrictHttpResponse<Array<Privilege>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/privileges`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<Privilege>>;
      })
    );
  }
  /**
   * @return OK
   */
  getPrivilegesUsingGET(): __Observable<Array<Privilege>> {
    return this.getPrivilegesUsingGETResponse().pipe(
      __map(_r => _r.body as Array<Privilege>)
    );
  }

  /**
   * @param newPrivilege newPrivilege
   * @return OK
   */
  addPrivilegeUsingPOSTResponse(newPrivilege: Privilege): __Observable<__StrictHttpResponse<{}>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = newPrivilege;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/privileges/add`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<{}>;
      })
    );
  }
  /**
   * @param newPrivilege newPrivilege
   * @return OK
   */
  addPrivilegeUsingPOST(newPrivilege: Privilege): __Observable<{}> {
    return this.addPrivilegeUsingPOSTResponse(newPrivilege).pipe(
      __map(_r => _r.body as {})
    );
  }

  /**
   * @param name name
   * @return OK
   */
  deletePrivilegeUsingGETResponse(name: string): __Observable<__StrictHttpResponse<{}>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/privileges/delete/${encodeURIComponent(name)}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<{}>;
      })
    );
  }
  /**
   * @param name name
   * @return OK
   */
  deletePrivilegeUsingGET(name: string): __Observable<{}> {
    return this.deletePrivilegeUsingGETResponse(name).pipe(
      __map(_r => _r.body as {})
    );
  }

  /**
   * @param roleName roleName
   * @return OK
   */
  getPrivilegesForRoleUsingGETResponse(roleName: string): __Observable<__StrictHttpResponse<Array<Privilege>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/privileges/forRole/${encodeURIComponent(roleName)}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<Privilege>>;
      })
    );
  }
  /**
   * @param roleName roleName
   * @return OK
   */
  getPrivilegesForRoleUsingGET(roleName: string): __Observable<Array<Privilege>> {
    return this.getPrivilegesForRoleUsingGETResponse(roleName).pipe(
      __map(_r => _r.body as Array<Privilege>)
    );
  }
}

module PrivilegeManagementControllerImplService {
}

export { PrivilegeManagementControllerImplService }
