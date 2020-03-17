/* tslint:disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpHeaders } from '@angular/common/http';
import { BaseService as __BaseService } from '../base-service';
import { ApiConfiguration as __Configuration } from '../api-configuration';
import { StrictHttpResponse as __StrictHttpResponse } from '../strict-http-response';
import { Observable as __Observable } from 'rxjs';
import { map as __map, filter as __filter } from 'rxjs/operators';

import { Role } from '../models/role';

/**
 * Role Management Controller Impl
 */
@Injectable({
  providedIn: 'root',
})
class RoleManagementControllerImplService extends __BaseService {
  static readonly getRolesUsingGETPath = '/roles';
  static readonly addRoleUsingPOSTPath = '/roles/add';
  static readonly deleteRoleUsingGETPath = '/roles/delete/{name}';
  static readonly getRolesForUserUsingGETPath = '/roles/forUser/{email}';
  static readonly getRoleByNameUsingGETPath = '/roles/{name}';

  constructor(
    config: __Configuration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * @return OK
   */
  getRolesUsingGETResponse(): __Observable<__StrictHttpResponse<Array<Role>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/roles`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<Role>>;
      })
    );
  }
  /**
   * @return OK
   */
  getRolesUsingGET(): __Observable<Array<Role>> {
    return this.getRolesUsingGETResponse().pipe(
      __map(_r => _r.body as Array<Role>)
    );
  }

  /**
   * @param newRole newRole
   * @return OK
   */
  addRoleUsingPOSTResponse(newRole: Role): __Observable<__StrictHttpResponse<{}>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = newRole;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/roles/add`,
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
   * @param newRole newRole
   * @return OK
   */
  addRoleUsingPOST(newRole: Role): __Observable<{}> {
    return this.addRoleUsingPOSTResponse(newRole).pipe(
      __map(_r => _r.body as {})
    );
  }

  /**
   * @param name name
   * @return OK
   */
  deleteRoleUsingGETResponse(name: string): __Observable<__StrictHttpResponse<{}>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/roles/delete/${encodeURIComponent(name)}`,
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
  deleteRoleUsingGET(name: string): __Observable<{}> {
    return this.deleteRoleUsingGETResponse(name).pipe(
      __map(_r => _r.body as {})
    );
  }

  /**
   * @param email email
   * @return OK
   */
  getRolesForUserUsingGETResponse(email: string): __Observable<__StrictHttpResponse<Array<Role>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/roles/forUser/${encodeURIComponent(email)}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<Role>>;
      })
    );
  }
  /**
   * @param email email
   * @return OK
   */
  getRolesForUserUsingGET(email: string): __Observable<Array<Role>> {
    return this.getRolesForUserUsingGETResponse(email).pipe(
      __map(_r => _r.body as Array<Role>)
    );
  }

  /**
   * @param name name
   * @return OK
   */
  getRoleByNameUsingGETResponse(name: string): __Observable<__StrictHttpResponse<Role>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/roles/${encodeURIComponent(name)}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Role>;
      })
    );
  }
  /**
   * @param name name
   * @return OK
   */
  getRoleByNameUsingGET(name: string): __Observable<Role> {
    return this.getRoleByNameUsingGETResponse(name).pipe(
      __map(_r => _r.body as Role)
    );
  }
}

module RoleManagementControllerImplService {
}

export { RoleManagementControllerImplService }
