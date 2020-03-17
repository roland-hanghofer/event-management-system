/* tslint:disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpHeaders } from '@angular/common/http';
import { BaseService as __BaseService } from '../base-service';
import { ApiConfiguration as __Configuration } from '../api-configuration';
import { StrictHttpResponse as __StrictHttpResponse } from '../strict-http-response';
import { Observable as __Observable } from 'rxjs';
import { map as __map, filter as __filter } from 'rxjs/operators';

import { User } from '../models/user';

/**
 * User Management Controller Impl
 */
@Injectable({
  providedIn: 'root',
})
class UserManagementControllerImplService extends __BaseService {
  static readonly getUsersUsingGETPath = '/users';
  static readonly addUserUsingPOSTPath = '/users/add';
  static readonly deleteUserUsingGETPath = '/users/delete/{email}';
  static readonly disableUserUsingGETPath = '/users/disable/{email}';
  static readonly enableUserUsingGETPath = '/users/enable/{email}';
  static readonly getUserByEmailUsingGETPath = '/users/{email}';
  static readonly changePasswordUsingPOSTPath = '/users/{email}/changePassword';

  constructor(
    config: __Configuration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * @return OK
   */
  getUsersUsingGETResponse(): __Observable<__StrictHttpResponse<Array<User>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/users`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<User>>;
      })
    );
  }
  /**
   * @return OK
   */
  getUsersUsingGET(): __Observable<Array<User>> {
    return this.getUsersUsingGETResponse().pipe(
      __map(_r => _r.body as Array<User>)
    );
  }

  /**
   * @param newUser newUser
   * @return OK
   */
  addUserUsingPOSTResponse(newUser: User): __Observable<__StrictHttpResponse<{}>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = newUser;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/users/add`,
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
   * @param newUser newUser
   * @return OK
   */
  addUserUsingPOST(newUser: User): __Observable<{}> {
    return this.addUserUsingPOSTResponse(newUser).pipe(
      __map(_r => _r.body as {})
    );
  }

  /**
   * @param email email
   * @return OK
   */
  deleteUserUsingGETResponse(email: string): __Observable<__StrictHttpResponse<{}>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/users/delete/${encodeURIComponent(email)}`,
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
   * @param email email
   * @return OK
   */
  deleteUserUsingGET(email: string): __Observable<{}> {
    return this.deleteUserUsingGETResponse(email).pipe(
      __map(_r => _r.body as {})
    );
  }

  /**
   * @param email email
   * @return OK
   */
  disableUserUsingGETResponse(email: string): __Observable<__StrictHttpResponse<{}>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/users/disable/${encodeURIComponent(email)}`,
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
   * @param email email
   * @return OK
   */
  disableUserUsingGET(email: string): __Observable<{}> {
    return this.disableUserUsingGETResponse(email).pipe(
      __map(_r => _r.body as {})
    );
  }

  /**
   * @param email email
   * @return OK
   */
  enableUserUsingGETResponse(email: string): __Observable<__StrictHttpResponse<{}>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/users/enable/${encodeURIComponent(email)}`,
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
   * @param email email
   * @return OK
   */
  enableUserUsingGET(email: string): __Observable<{}> {
    return this.enableUserUsingGETResponse(email).pipe(
      __map(_r => _r.body as {})
    );
  }

  /**
   * @param email email
   * @return OK
   */
  getUserByEmailUsingGETResponse(email: string): __Observable<__StrictHttpResponse<User>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/users/${encodeURIComponent(email)}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<User>;
      })
    );
  }
  /**
   * @param email email
   * @return OK
   */
  getUserByEmailUsingGET(email: string): __Observable<User> {
    return this.getUserByEmailUsingGETResponse(email).pipe(
      __map(_r => _r.body as User)
    );
  }

  /**
   * @param params The `UserManagementControllerImplService.ChangePasswordUsingPOSTParams` containing the following parameters:
   *
   * - `oldPassword`: oldPassword
   *
   * - `newPassword`: newPassword
   *
   * - `email`: email
   *
   * @return OK
   */
  changePasswordUsingPOSTResponse(params: UserManagementControllerImplService.ChangePasswordUsingPOSTParams): __Observable<__StrictHttpResponse<{}>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = params.oldPassword;
    __body = params.newPassword;
    __body = params.email;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/users/${encodeURIComponent(params.email)}/changePassword`,
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
   * @param params The `UserManagementControllerImplService.ChangePasswordUsingPOSTParams` containing the following parameters:
   *
   * - `oldPassword`: oldPassword
   *
   * - `newPassword`: newPassword
   *
   * - `email`: email
   *
   * @return OK
   */
  changePasswordUsingPOST(params: UserManagementControllerImplService.ChangePasswordUsingPOSTParams): __Observable<{}> {
    return this.changePasswordUsingPOSTResponse(params).pipe(
      __map(_r => _r.body as {})
    );
  }
}

module UserManagementControllerImplService {

  /**
   * Parameters for changePasswordUsingPOST
   */
  export interface ChangePasswordUsingPOSTParams {

    /**
     * oldPassword
     */
    oldPassword: string;

    /**
     * newPassword
     */
    newPassword: string;

    /**
     * email
     */
    email: string;
  }
}

export { UserManagementControllerImplService }
