/* tslint:disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpHeaders } from '@angular/common/http';
import { BaseService as __BaseService } from '../base-service';
import { ApiConfiguration as __Configuration } from '../api-configuration';
import { StrictHttpResponse as __StrictHttpResponse } from '../strict-http-response';
import { Observable as __Observable } from 'rxjs';
import { map as __map, filter as __filter } from 'rxjs/operators';

import { Tournament } from '../models/tournament';
import { Ticket } from '../models/ticket';
import { TournamentDay } from '../models/tournament-day';
import { PairTicketSponsor } from '../models/pair-ticket-sponsor';

/**
 * Tournament Controller Impl
 */
@Injectable({
  providedIn: 'root',
})
class TournamentControllerImplService extends __BaseService {
  static readonly getTournamentsUsingGETPath = '/tournaments';
  static readonly addTournamentUsingPOSTPath = '/tournaments/add';
  static readonly getTicketForTournamentDayUsingGETPath = '/tournaments/days/{id}/tickets';
  static readonly getTournamentDaysUsingGETPath = '/tournaments/getDays/{id}';
  static readonly getTournamentDaysAndTicketsUsingGETPath = '/tournaments/getDaysAndTickets/{id}';

  constructor(
    config: __Configuration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * @return OK
   */
  getTournamentsUsingGETResponse(): __Observable<__StrictHttpResponse<Array<Tournament>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/tournaments`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<Tournament>>;
      })
    );
  }
  /**
   * @return OK
   */
  getTournamentsUsingGET(): __Observable<Array<Tournament>> {
    return this.getTournamentsUsingGETResponse().pipe(
      __map(_r => _r.body as Array<Tournament>)
    );
  }

  /**
   * @param tournament tournament
   * @return OK
   */
  addTournamentUsingPOSTResponse(tournament: Tournament): __Observable<__StrictHttpResponse<{}>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = tournament;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/tournaments/add`,
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
   * @param tournament tournament
   * @return OK
   */
  addTournamentUsingPOST(tournament: Tournament): __Observable<{}> {
    return this.addTournamentUsingPOSTResponse(tournament).pipe(
      __map(_r => _r.body as {})
    );
  }

  /**
   * @param id id
   * @return OK
   */
  getTicketForTournamentDayUsingGETResponse(id: number): __Observable<__StrictHttpResponse<Array<Ticket>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/tournaments/days/${encodeURIComponent(id)}/tickets`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<Ticket>>;
      })
    );
  }
  /**
   * @param id id
   * @return OK
   */
  getTicketForTournamentDayUsingGET(id: number): __Observable<Array<Ticket>> {
    return this.getTicketForTournamentDayUsingGETResponse(id).pipe(
      __map(_r => _r.body as Array<Ticket>)
    );
  }

  /**
   * @param id id
   * @return OK
   */
  getTournamentDaysUsingGETResponse(id: number): __Observable<__StrictHttpResponse<Array<TournamentDay>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/tournaments/getDays/${encodeURIComponent(id)}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<TournamentDay>>;
      })
    );
  }
  /**
   * @param id id
   * @return OK
   */
  getTournamentDaysUsingGET(id: number): __Observable<Array<TournamentDay>> {
    return this.getTournamentDaysUsingGETResponse(id).pipe(
      __map(_r => _r.body as Array<TournamentDay>)
    );
  }

  /**
   * @param id id
   * @return OK
   */
  getTournamentDaysAndTicketsUsingGETResponse(id: number): __Observable<__StrictHttpResponse<{[key: string]: Array<PairTicketSponsor>}>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/tournaments/getDaysAndTickets/${encodeURIComponent(id)}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<{[key: string]: Array<PairTicketSponsor>}>;
      })
    );
  }
  /**
   * @param id id
   * @return OK
   */
  getTournamentDaysAndTicketsUsingGET(id: number): __Observable<{[key: string]: Array<PairTicketSponsor>}> {
    return this.getTournamentDaysAndTicketsUsingGETResponse(id).pipe(
      __map(_r => _r.body as {[key: string]: Array<PairTicketSponsor>})
    );
  }
}

module TournamentControllerImplService {
}

export { TournamentControllerImplService }
