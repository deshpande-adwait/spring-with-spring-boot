package com.reservationapp.landon.web.application;

import com.reservationapp.landon.business.domain.RoomReservation;
import com.reservationapp.landon.business.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/reservations")
public class ReservationController {

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private ReservationService reservationService;

    @RequestMapping(method = RequestMethod.GET)
    public String getReservations(@RequestParam(value = "date", required = false)
                                              String strDate, Model model) {

        List<RoomReservation> roomReservationList = this.reservationService.getRoomReservationsForDate(strDate);
        model.addAttribute("roomReservations", roomReservationList);
        return "reservations";
    }
}
